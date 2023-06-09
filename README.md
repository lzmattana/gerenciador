# Gerenciador de Empresas Java com Servlet e Tomcat 9.0

Este é um projeto Java para um gerenciador de empresas que utiliza o conceito de CRUD (Create, Read, Update e Delete) e foi desenvolvido com Servlet e Tomcat 9.0. 

## Pré-requisitos

Antes de começar, você deve ter as seguintes ferramentas instaladas em sua máquina:

- Java 8 ou superior
- Apache Tomcat 9.0 ou superior

## Instalação

Siga os passos abaixo para instalar e executar o projeto em sua máquina:

1. Clone este repositório:

    ```
    git clone https://github.com/lzmattana/gerenciador.git
    ```

2. Importe o projeto em sua IDE Java de preferência.

3. Execute o Tomcat 9.0.

4. Execute o projeto na IDE ou faça o deploy do WAR gerado na pasta `target` no Tomcat.

5. Acesse a aplicação em seu navegador pelo endereço [http://localhost:8080/gerenciador](http://localhost:8080/gerenciador).

## Endpoints

Abaixo estão os endpoints disponíveis na aplicação:

- `/gerenciador`: bem vindo do projeto.
- http://localhost:8080/gerenciador/entrada?acao=LoginForm : formulario de login.
- http://localhost:8080/gerenciador/entrada?acao=ListaEmpresas : lista de empresas.
- http://localhost:8080/gerenciador/entrada?acao=NovaEmpresaForm : formulario de nova empresa.
- http://localhost:8080/gerenciador/entrada?acao=MostraEmpresa&id= : edita a empresa.


## Tecnologias

As seguintes tecnologias foram utilizadas neste projeto:

- Java
- Servlet
- Tomcat 9.0
- Maven

## Contribuindo

1. Faça o _fork_ deste repositório.

2. Crie uma _branch_ para sua nova _feature_:

    ```
    git checkout -b feature/nova-feature
    ```

3. Faça as alterações necessárias e _commit_:

    ```
    git commit -m "Mensagem explicando sua nova feature"
    ```

4. Faça o _push_ para o seu _fork_:

    ```
    git push origin feature/nova-feature
    ```

5. Crie um novo _pull request_.

## Esquema de aplicação:
![image](https://user-images.githubusercontent.com/114715875/236308138-67bf0d8c-02f7-484d-b38a-885e824df94b.png)

