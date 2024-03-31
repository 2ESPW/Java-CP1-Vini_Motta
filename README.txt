================== RECURSOS ==================

O programa de criptografia é composto por duas ferramentas:
- Tradutor de código morse
- Gerador de cifra de cesar

O Tradutor de código morse é capaz de receber textos (letras e
números, não aceitando caracteres especiais), e traduzí-los
para a linguagem de código morse (que utiliza "." e "-" para
representar as letras e números), e também receber textos em
formato de código morse e traduzí-los para texto convencional
(com letras e números)

Já o gerador de cifra de cesar é capaz de criptografar uma 
mensagem de texto convencional através da metodologia da cifra
de Cesar, que consiste em uma cifra de substituição onde cada 
letra é substituida por outra que se apresenta no alfabeto após
a ele um número fixo de vezes.

Você pode navegar entre as ferramentas através das escolhas
oferecidas pelos menus do programa, onde também terá a opção de
encerrar a aplicação, caso não deseje mais utilizá-la.

================== EXECUÇÃO ===================

Para executar o programa, inicie o arquivo "criptografia.java" 
na IDE de sua escolha (garanta que a IDE seja capaz de fazer o
debug e execuçãode arquivos .java).

Após isso, basta seguir as instruções apresentadas pelos menus
do programa e avisos em caso de entradas inválidas de dados.

================== UTILIZAÇÃO DAS FERRAMENTAS ==================

Para utilizar o tradutor de código morse, basta selecionar se
a mensagem a ser inseida está em texto convencional, ou em 
código morse, e então inserir a mensagem para ser traduzida.

Ao inserir uma mensagem em texto convencional, utilize apenas
letras e números, sem caracteres especiais. O programa irá
informar caso a mensagem inserida seja inválida.

Ao inserir uma mensagem em código morse, utiize apenas 
pontos (.) e traços (-) para representar as letras e números.
Inclua espaços em branco (" ") para separar uma letra da 
outra, e barras (/) para separar as palavras. Não utilize
letras, números ou outros caracteres especiias. O programa 
irá informar caso a mensagem inserida seja inválida. 

================== COMPOSIÇÃO DO PROGRAMA ==================

O programa está dividido em 3 arquivos separados:
- criptografia.java
- morse.java
- cesar.java

criptgrafia.java é o arquivo controlador, que deve ser 
executado para utiização do progarama, e que faz chamadas 
nos outros arquivos dependendo dos inputs feitos pelo 
usuário.

morse.java é o código que contem o tradutor de código morse,
que recebe mensagens do usuário e as traduz para texto
convencional ou código morse, dependendo da solicitação
feita pelo usuário.

cesar.java é o código da ferramenta de criptografia em
cifra de cesar, que recebe mensagens do usuário e as 
modifica através da cifra de substuição de cesar, seja 
para criptografar ou descriptografar dependendo da 
solicitação feita pelo usuário.

A manutenção e ajuste das ferramentas presentes no código
devem ser feitas em seus respectivos arquivos, atentando
apenas ao vínculo realizado com o arquivo principal
(criptografia.java).
