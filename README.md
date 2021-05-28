## jEdit Macro: Beautify Text Table

This macro aligns character-separated text.


### Installation:


Just change the extension from .java to .bsh e put it in the following path:


```
jedit
│   jedit.jar
│   ...
│
└───macros
    │
    └───text (on any other of your preference)
        │   Beautify_Table.bsh
        │   ...
```

Restart the application



### How to execute


Open some .csv file:

You can download them from several places, like:
https://www.anatel.gov.br/dadosabertos/PDA/TV_por_assinatura/TVA.csv

Sample:
```
nomefase,siglauf,nomemunicipio,nomeentidade
Licenciada,RJ,Rio de Janeiro,TV O DIA S/A
Licenciada,RS,Porto Alegre,BOA VENTURA EMPRESA
Licenciada,PR,Curitiba,TELEVISÃO TRANSAMÉRI
Licenciada,SP,São Paulo,BOA VENTURA EMPRESA
Licenciada,RJ,Rio de Janeiro,BOA VENTURA EMPRESA
Licenciada,ES,Vitória,TV 2000 LTDA
Licenciada,MG,Belo Horizonte,SISTEMA UNIVERSAL DE
```

Select the lines you want to format.

Macros > Text > Beautify Table > Choose Delimiter > Comma (,)

Result:

```
nomefase   , siglauf , nomemunicipio  , nomeentidade
Licenciada , RJ      , Rio de Janeiro , TV O DIA S/A
Licenciada , RS      , Porto Alegre   , BOA VENTURA EMPRESA
Licenciada , PR      , Curitiba       , TELEVISÃO TRANSAMÉRI
Licenciada , SP      , São Paulo      , BOA VENTURA EMPRESA
Licenciada , RJ      , Rio de Janeiro , BOA VENTURA EMPRESA
Licenciada , ES      , Vitória        , TV 2000 LTDA
Licenciada , MG      , Belo Horizonte , SISTEMA UNIVERSAL DE
```
