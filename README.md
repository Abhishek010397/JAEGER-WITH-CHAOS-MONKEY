## DISTRIBUTED TRACING

Most of the times, one microservice might depend on another microservice to process a request. In that case when the client/browser sends a request to one of the microservices, then the request could be processed by multiple microservices internally before the client/browser gets the response. If everything goes fine, It is great. But what If one of the microservices fails / throws an exception during some processing.

This unhandled exception would be propagated to other microservices & finally to the client. Depending on the design, a microservice might receive requests from N number of microservices. In that case, we might need to trace the complete request from the client to the last microservice in the request processing chain. So that we could understand what really happened and which service failed when a particular request was sent.

If the user experiences application slowness, how can we locate the specific service which is causing the performance issue when there are N number of services.So, Distributed Tracing is a way of understanding the complete chain of events in Microservices based architecture.

1.Jaeger presents execution requests as traces. A trace shows the data/execution path through a system. 
A trace is made up of one or more spans. A span is a logical unit of work in Jaeger. Each span includes the operation name, start time, and duration. Spans may be nested and ordered.Jaeger includes several components that work together to collect, store and visualize spans and traces.

2.Jaeger Client includes language-specific implementations of the OpenTracing API for distributed tracing.    These can be used manually or with a variety of open source frameworks.Jaeger Agent is a network daemon that listens for spans sent over User Datagram Protocol. The agent is meant to be placed on the same host as the instrumented application. This is usually implemented through a sidecar in container environments like Kubernetes.

3.Jaeger Collector receives spans and places them in a queue for processing.Collectors require a persistent storage backend, so Jaeger also has a pluggable mechanism for span storage. 
Query is a service that retrieves traces from storage.
Jaeger Console is a user interface that lets you visualize your distributed tracing data.

## INSTALLATION

1. First clone the project using:-
  
          https://github.com/Abhishek010397/JAEGER-WITH-CHAOS-MONKEY.git

2. Install Docker on you system inorder to run Jaeger as:-
       
          docker run -d --name jaeger-ui -p 16686:16686 -p 6831:6831/udp jaegertracing/all-in-one:1.9

3. I have made use of Intellij to compile and build my Client and Server Code

4. To perform Chaos Testing :-
      

           1. Have Python3 Installed on your machine
           2. Create a directory called chaostk
           3. Create a python virtual env
           4. Activate that virtualenv
           5. Run chaos run command followed by experiment.json file path