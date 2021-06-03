# sample_virtual_internet_platform
## Info
This repository is a publicly available copy of the Virtual Internet Platform (VIP). The primary goal of the project was to create a virtual copy of the Internet which could be used for testing network traffic and load in a fully controlled environment.

As the true project resides on GitLab as a multirepository, this monorepository would have to be adjusted with git to work properly.

The VIP was made by me, as a software engineering bachelor project on 5th semester at SDU Odense. It was made over a period from September 1. 2020 - January 4. 2021.

## What the VIP does right
* All big features are made as independent microservices.
* Every service is separated in presentation, domain and persistence layers making for an easy to work with architecture.
* Incorporates tons of interfaces making it easy to modify and replace implementation.

The result is an easy to work with, easy to understand, clean software that is also easy to modify and improve upon. Services are also testable independently which means the whole system does not have to be started every time a feature is tested.

## What the VIP does wrong
* Becomes clumsy as it tries to incorporate too many healthy design patterns too early in its life cycle.
* Performance is less than optimal as every microservice uses REST but at the same time has to transfer tons of data frequently.

The negatives are that it has become slow (but easy) to create trans microservice changes, as there are many layers and services. The worst part is probably that setting up the project with its many repositories and sub modules can become tedious if done frequently.
