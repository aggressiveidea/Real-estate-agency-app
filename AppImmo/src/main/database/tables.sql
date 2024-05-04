CREATE TABLE login (
    nomutilisateur VARCHAR2(15),
    motdepasse VARCHAR2(15) NOT NULL,
    id NUMBER(7) PRIMARY KEY NOT NULL,
    NUM INT NOT NULL
);

CREATE TABLE infoframe (
    nom VARCHAR2(15) NOT NULL,
    prenom VARCHAR2(15) NOT NULL,
    telephone VARCHAR2(10) NOT NULL,
    email VARCHAR2(35) NOT NULL,
    typeuser VARCHAR2(30),
    ID_INFO NUMBER(7) PRIMARY KEY NOT NULL,
    CONSTRAINT fk_id_info FOREIGN KEY (ID_INFO) REFERENCES login(id)
);


CREATE TABLE Proprietaire (
    IDpropr NUMBER(7) PRIMARY KEY NOT NULL,
    Nompropr VARCHAR2(15),
    Prenompropr VARCHAR2(20),
    Emailpropr VARCHAR2(40),
    telephonepropr VARCHAR2(10),
    CONSTRAINT fk_Proprietaire FOREIGN KEY (IDpropr) REFERENCES infoframe(ID_INFO)
);

CREATE TABLE AgentImm (
    IDagent NUMBER(7) PRIMARY KEY NOT NULL,
    NomAgent VARCHAR2(15),
    PrenomAgent VARCHAR2(20),
    EmailAgent VARCHAR2(40),
    telephoneAgAJent VARCHAR2(10),
    CONSTRAINT fk_AgentImm FOREIGN KEY (IDagent) REFERENCES infoframe(ID_INFO)
);

CREATE TABLE Client (
    IDclient NUMBER(7) PRIMARY KEY NOT NULL,
    NomClient VARCHAR2(15),
    prenomClient VARCHAR2(20),
    AdressClient VARCHAR2(30),
    EmailClient VARCHAR2(45),
    telephoneClient VARCHAR2(10),
    CONSTRAINT fk_Client FOREIGN KEY (IDclient) REFERENCES infoframe(ID_INFO)
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
    Heurtrans TIMESTAMP,
    CltID NUMBER(7) NOT NULL, 
    CONSTRAINT fk_id_BienImmobilier FOREIGN KEY (IDtransaction) REFERENCES BienImmobilier(IDbien),
    CONSTRAINT fk_id_Client FOREIGN KEY (CltID) REFERENCES Client(IDclient)
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
    Typeinter VARCHAR2(15),
    Dateintr DATE,
    Descriptioninter VARCHAR2(255),
    AgentID NUMBER(7) NOT NULL,
    ClientID NUMBER(7) NOT NULL,
    CONSTRAINT fk__AgentID FOREIGN KEY (AgentID) REFERENCES AgentImm(IDagent),
    CONSTRAINT fk__ClientID FOREIGN KEY (ClientID) REFERENCES Client(IDclient)
);
//