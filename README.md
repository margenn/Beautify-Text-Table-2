## jEdit Macro: Beautify Text Table

This macro aligns character-separated text.

It is a upgraded version of the original "Beautify Text Table".
     
     
### Improvements:
     
     
- Dialog box. Allows the user to choose the correct separator.
- String concatenation replaced by StringBuilder. Faster.
- Checking the same number of columns across the entire selection before applying changes. Avoids previous NPC exceptions.
- Metrics. Warns if a odd line has been found. Indicates the line number and its quantity of columns.
- Metrics. Execution time.


![BeautifyText2](https://user-images.githubusercontent.com/8531218/160283549-343f93c0-022f-4e12-b29b-4d6b5c5ce72d.gif)



### Installation:


Just change the extension from .java to .bsh e put it in the following path:


```
jedit
│   jedit.jar
│   ...
│
└───macros
    │
    └───misc (on any other of your preference)
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
