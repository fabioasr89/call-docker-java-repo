# call-docker-java-repo

Semplice microservizio containerizzato che espone un servizio che recupera le info dei vari container che girano sulla macchina.
Nel mio caso ho esposto un servizio che recupera i nomi dei vari container, e ne stampa uno in paricolare (quello in cui il service viene eseguito).

Per far funzionare il giro occorre importare sia la libreria docker-java come dipendenza maven, ed esternamente, sia la libreria junixsocket, che poi andrà settata 
nel classpath dell'applicativo- Al run del container occorrerà montare  docker.sock, eseguendo il comando:

docker run -v /var/run/docker.sock:/var/run/docker.sock --name app-docker-test-container -p8080:8090 app-docker

