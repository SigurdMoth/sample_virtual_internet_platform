package dk.vip.protocols.http.domain;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.springframework.stereotype.Service;

import dk.vip.protocols.http.domain.methods.HttpGet;
import dk.vip.protocols.http.domain.methods.HttpMethod;
import dk.vip.protocols.http.domain.methods.HttpPost;
import dk.vip.protocols.http.presentation.IUnwrapper;
import dk.vip.expression.Expression;
import dk.vip.wrap.Wrap;

@Service
public class Unwrapper implements IUnwrapper {
	Logger logger = Logger.getLogger(Unwrapper.class.getName());

	@Override
	public String handle(String request) {
		// unwrap
		Gson gson = new Gson();
		Wrap httpWrap = null;
		try {
			httpWrap = gson.fromJson(request, Wrap.class);
			Expression expression = httpWrap.getExpression();

			// HTTP method
			HttpMethod method = null;
			switch (expression.getCommand().toLowerCase()) {
				case "get":
					method = new HttpGet();
					break;
				case "post":
					method = new HttpPost();
					break;
				case "put":
					break;
				case "delete":
					break;
			}
			// receive answer
			Wrap returnedWrap = null;
			if (method != null) {
				returnedWrap = method.run(httpWrap, request);
			} else {
				logger.log(Level.INFO, "method is null");
			}
			// wrap answer
			return gson.toJson(returnedWrap);
		} catch (JsonSyntaxException e) {
			logger.log(Level.WARNING, "Failed to unwrap Json wrapper", e);
		}

		return null;
	}

}
