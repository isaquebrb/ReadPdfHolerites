# ReadPdfHolerites
Simple demonstration of how to apply SOLID principles in a read pdf class java

### Single responsibility principle
**S** *Branch*: A classe *Main* foi separada em outras classes, dividindo assim sua responsabilidade, ela não faz mais todo o serviço do programa. Há uma classe para a captura de arquivos, uma para a leitura do pdf, uma para capturar valores do texto do pdf, uma para imprimir mensagens...
### Open–closed principle
**O** *Branch*: A classe de envio de mensagem (*Print*) foi alterada para se comportar como interface, ou seja ela está "fechada" para alterações. Dessa forma, sempre que necessário, parar alterar alguma regra do print de mensagens, bastará criar uma nova classe e sua nova regra.
### Liskov substitution principle
**L** *Branch*: A classe *Holerite* foi derivada em outras duas classes (*HolerideServidor* e *HoleritePensionista*). Utilizamos a **composição** para evitar que demais tipos de holerites tenham métodos inúteis implementados provenientes de uma **herança** mal implementada. No caso, os holerites do tipo servidor e pensionista, compõe um holerite.
### Interface segregation principle
**I** *Branch*: Geramos duas interfaces (*IPrintPensionista*, *IPrintServidor*) através da interface *IPrint*, para que o método envio de mensagens não fique sendo implementado através de apenas uma interface, assim cada tipo de holerite terá seu método customizado, evitando uma classe "gorda" com muitos aclopamentos.
### Dependency inversion principle
**D** *Branch*: Criamos a classe *CapturarCampos* que será responsável por receber um **texto** e que também possui o método de captura de valor. Extendemos a classe *CamposHolerite* dessa, para que ela possa através do texto e da captura de valores, pegar os atributos dos holerites e guardá-los. A inversão de dependência pode ser vista no texto que deve ser enviado ao instanciar a classe *CamposHolerite*.

## Execução
Antes de executar, altere o caminho presente na linha:
*new Arquivos("C:\\Users\\Isaque\\eclipse-workspace\\Holerites\\files");*
Nele deve estar contido o caminho da pasta files do projeto na sua máquina.
