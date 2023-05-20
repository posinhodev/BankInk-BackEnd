# Backend Para Bank Ink

## Introducción

## Tecnologías utilizadas
Para este proyecto fueron utlizadas las tecnologias descritas a continuacion:

**1.  Backend**

![ alt text ](https://img.shields.io/badge/java-11-0085CA?style=for-the-badge&logo=java)  ![ alt text ](https://img.shields.io/badge/springboot-2.7.12-6DB33F?style=for-the-badge&logo=springboot) ![ alt text ](https://img.shields.io/badge/Swagger-1.6.9-85EA2D?style=for-the-badge&logo=Swagger) 

**2.  Base de datos**

![ alt text ](https://img.shields.io/badge/postgresql-15-4169E1?style=for-the-badge&logo=postgresql)

**3.  Probar las API Rest**

![ alt text ](https://img.shields.io/badge/postman-10.14-FF6C37?style=for-the-badge&logo=postman)

** 4. IDEA **

![ alt text ](https://img.shields.io/badge/intellijidea-2023.1-000000?style=for-the-badge&logo=intellijidea)

## Instalacion de backend
Como prerequisitos debemos de tenre instaladas las tecnologais mensionadas antes, para esto vamos a validar que este instalado **java** con el comando `$ Java --version`, validar que este instalado y configurado **postgresql**, validar que este instalado **postman** para poder probar nuestros servicios.

Despues de ya haber validado esto vamos a dirigirnos al apartado de code en la pagina principal del repositorio (https://github.com/posinhodev/BankInk-BackEnd), en esta opcion nos desplega un menu en el cual podemos realizar un clon del repositorio o podemos descargar el codigo directamente en in .zip.

Para este ejemplo de descarga del ambiente vamos a usar la opcion de clonar el repositorio mediante HTTP, para esto vamos a seguir el siguiente paso a paso:

**1.**  vamos a darle clic ak boton de Code en la pagina principal del repositorio, nos desplegara varias opciones y en la opcion de http vamos a copiar el link que aparece abajo.

**2.** vamos a abrir el IDEA en este caso se uso **Intellij IDEA** y en el apartado principal veremos que hay una opcion que dice **Get from VCS** y en el apartado de url pondremos el link que copiamos antes.

**3.** despues de esto comenzara a clonarse el repositorio dentro de la carpeta que selecionamos y ya tendremos el codigo descargado.

**4.** para iniciar el codigo debemos de dirigirnos al apartado de maven y le daremos al boton de **Reload All Maven Projects** y se comenzaran a descargar las dependencias del pom.xml

**5.** antes de poder ejecutar el proyecto vamos a ingresar al gestor de base de datos que se pidio como prerequisito el cual es **PostgreSQL** y ya teniendolo configurado vamos a crear con una nueva instancia de la base de datos llamada **BankInk**.

**6.** ahora tendremos que dirigirnos al archivo application.properties y pondremos nuestro **usuario y contraseña** para realizar la conexion a la base de datos que creamos.

**7.** y ya teniendo configurada la conexion con la base de datos, nos diriremos al archivo de BackEndBankInkApplication.java en donde ejecutaremos por primera vez el programa con la segunda fecla verde que esta en la clase main.

## Probando los servicios REST

Despues de tener la aplicacion ejecutandose vamos a dirigirnos al siguiente url con la que podremos ver los servicios REST que se tienen desde el swagger: http://localhost:8089/bank/api/swagger-ui/index.html#/ , mediante esta url podemos probar los servicios tambien pero tambien usaremos la herramienta de **postman** de la cual se tiene una coleccion en repositorio del proyecto donde ya se tienen configuradas pruebas iniciales y donde se pueden cambiar los valores para pruebas.

## Datos de contacto

| Nombres  | Correo  | Telefono | Redes |
| :------------ |:---------------:| -----:| -----:|
| Jose Santiago Posso Parra | jose.possop12@gmail.com | 3126917902 | https://www.linkedin.com/in/jose-santiago-posso-parra/ |

               
## End
