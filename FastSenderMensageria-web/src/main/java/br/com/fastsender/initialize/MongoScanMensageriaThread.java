package br.com.fastsender.initialize;

import br.com.fastsender.mongo.connection.MongoDBConnection;
import br.com.fastsender.mongo.facade.XmlFacade;
import com.mongodb.DB;
import com.mongodb.DBObject;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * @author lucas
 */
public class MongoScanMensageriaThread implements Runnable {

    private static Logger LOG4J = Logger.getLogger(MongoScanMensageriaThread.class);
    private XmlFacade xmlFacade;
    private List<DBObject> xmlNfseList;
    private MongoDBConnection MONGODB_CONNECTION = new MongoDBConnection();
    
    @Override
    public void run() {
        LOG4J.info("THREAD INICIADA - [INICIANDO CONSULTA XML NFSE]");
        DB db = MONGODB_CONNECTION.getDB();
        xmlNfseList.addAll(getXmlFacade().recuperaXmls(db));
        
        try {
            Thread.sleep(100000l);
        } catch (InterruptedException ex) {
            LOG4J.error("");
        }
    }

    //Getters and setters
    public XmlFacade getXmlFacade() {
        if (xmlFacade == null){
            this.xmlFacade = new XmlFacade();
        }
        return xmlFacade;
    }

    public void setXmlFacade(XmlFacade xmlFacade) {
        this.xmlFacade = xmlFacade;
    }

    public List<DBObject> getXmlNfseList() {
        return xmlNfseList == null ? new ArrayList<DBObject>() : null;
    }

    public void setXmlNfseList(List<DBObject> xmlNfseList) {
        this.xmlNfseList = xmlNfseList;
    }
    
    
}
