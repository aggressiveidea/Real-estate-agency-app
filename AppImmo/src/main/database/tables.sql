CREATE TABLE login (
    nomutilisateur VARCHAR2(15),
    motdepasse VARCHAR2(15) NOT NULL,
    id NUMBER(7) PRIMARY KEY NOT NULL,
    typeuser VARCHAR2(30),
    NUM INT NOT NULL
);

CREATE TABLE Proprietaire (
    IDpropr NUMBER(7) PRIMARY KEY NOT NULL,
    Nompropr VARCHAR2(15),
    Prenompropr VARCHAR2(20),
    Emailpropr VARCHAR2(40),
    telephonepropr VARCHAR2(10),
    CONSTRAINT fk_Proprietaire FOREIGN KEY (IDpropr) REFERENCES login(id)
);

CREATE TABLE AgentImm (
    IDagent NUMBER(7) PRIMARY KEY NOT NULL,
    NomAgent VARCHAR2(15),
    PrenomAgent VARCHAR2(20),
    EmailAgent VARCHAR2(40),
    telephoneAgAJent VARCHAR2(10),
    CONSTRAINT fk_AgentImm FOREIGN KEY (IDagent) REFERENCES login(id)
);

CREATE TABLE Client (
    IDclient NUMBER(7) PRIMARY KEY NOT NULL,
    NomClient VARCHAR2(15),
    prenomClient VARCHAR2(20),
    AdressClient VARCHAR2(30),
    EmailClient VARCHAR2(45),
    telephoneClient VARCHAR2(10),
    CONSTRAINT fk_Client FOREIGN KEY (IDclient) REFERENCES login(id)
);

CREATE TABLE BienImmobilier (
    IDbien NUMBER(7) PRIMARY KEY NOT NULL,
    Typebien VARCHAR2(15),
    Taillebien NUMBER(10),
    Prixbien NUMERIC(9,2),
    Localbien VARCHAR2(40),
    Descbien VARCHAR2(600),
    AgentID NUMBER(7) NOT NULL,
    PropriID NUMBER(7) NOT NULL,
    CONSTRAINT fk_id_AgentImm FOREIGN KEY (AgentID) REFERENCES AgentImm(IDagent),
    CONSTRAINT fk_id_Proprietaire FOREIGN KEY (PropriID) REFERENCES Proprietaire(IDpropr)
);

CREATE TABLE Transactions (
    IDtransaction NUMBER(7) PRIMARY KEY,
    Typetrans VARCHAR2(15),
    Datetans DATE,
    CltID NUMBER(7),
    OwnerID NUMBER(7),
    AgentID NUMBER(7),
    Cost NUMBER(7),
    CONSTRAINT fk_id_Client FOREIGN KEY (CltID) REFERENCES Client(IDclient),
    CONSTRAINT fk_id_Owner FOREIGN KEY (OwnerID) REFERENCES Proprietaire(IDpropr),
    CONSTRAINT fk_id_Trans_AgentImm FOREIGN KEY (AgentID) REFERENCES AgentImm (IDagent)
);

CREATE TABLE PropertyContract (
    ID NUMBER(7) PRIMARY KEY NOT NULL,
    Type VARCHAR2(15),  
    DateDebut DATE,     
    DateFin DATE,
    BienID NUMBER(7) NOT NULL,
    ClientID NUMBER(7) NOT NULL,  
    AgentID NUMBER(7) NOT NULL,
    CONSTRAINT fk_BienID FOREIGN KEY (BienID) REFERENCES BienImmobilier(IDbien),
    CONSTRAINT fk_ClientID FOREIGN KEY (ClientID) REFERENCES Client(IDclient),
    CONSTRAINT fk_AgentID FOREIGN KEY (AgentID) REFERENCES AgentImm(IDagent)
);

CREATE TABLE Interaction (
    ID NUMBER(7) PRIMARY KEY NOT NULL,
    Dateintr DATE,
    Descriptioninter VARCHAR2(255),
    AgentID NUMBER(7) NOT NULL,
    ClientID NUMBER(7) NOT NULL,
    CONSTRAINT fk__AgentID FOREIGN KEY (AgentID) REFERENCES AgentImm(IDagent),
    CONSTRAINT fk__ClientID FOREIGN KEY (ClientID) REFERENCES Client(IDclient)
);

CREATE TABLE Payment (
    ID NUMBER(7) PRIMARY KEY,
    TransactionID NUMBER(7),
    Amount NUMBER(7),
    DatePay Date,
    CONSTRAINT fk_transactionID FOREIGN KEY (transactionID) REFERENCES Transactions(IDtransaction)
);

ALTER TABLE BienImmobilier
ADD (property_type VARCHAR2(100),
     property_papers VARCHAR2(100),
     p_specifications VARCHAR2(200));
     
ALTER TABLE BienImmobilier
DROP COLUMN property_type;

ALTER TABLE Client  DROP COLUMN  EmailClient;
ALTER TABLE Proprietaire  DROP COLUMN  Emailpropr;
ALTER TABLE AgentImm  DROP COLUMN EmailAgent;

ALTER TABLE Client ADD (EmailClient VARCHAR2(40));
ALTER TABLE Proprietaire ADD (Emailpropr VARCHAR2(40));
ALTER TABLE AgentImm ADD (EmailAgent VARCHAR2(40));
