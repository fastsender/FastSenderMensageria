package br.com.fastsender.initialize;

import javax.annotation.PostConstruct;
import org.apache.log4j.Logger;

/**
 * @author lucas
 */
public class StartingMensageria {

    private static Logger LOG4J = Logger.getLogger(StartingMensageria.class);
    
    public static void main(String[] args) {
        StartingMensageria start = new StartingMensageria();
        start.initializeMensageria();
    }
    
    public void initializeMensageria(){
        LOG4J.info("PREPARANDO PARA INICIAR A MENSAGERIA - [INICIANDO THREAD]");
        MongoScanMensageriaThread scanner = new MongoScanMensageriaThread();
        new Thread(scanner).start();
        System.out.println("INICIANDO CONSULTA DE XMLS");
    }
}
