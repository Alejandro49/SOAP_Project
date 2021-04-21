# SOAP_Project


## 1. Configuración Apache Tomcat 9 en Eclipse


- Pestaña Window
   - Preferences
      - Server => Runtime Environmets => Add => Seleccionar Apache Tomcat v9.0 => Seleccionar carpeta contenida en el proyecto (apache-tomcat-9.0.39) => Finish 

## 2. Importar Maven Project desde el Repo a eclipse (Realizar com ambos proyectos)

	1. Clonar repositorio donde se quiera
	
	2. Abrir Eclipse 
		- File => Import... => Maven => Existing Maven Projects => Next
		- Root directory: seleccionar Directorio del proyecto (ligaServer) dentro del repositorio
		- Aparecerá automaticamente el archivo pom.xml detectado
		- next => finish.
	
	Repetir proceso con ligaClient exactamente igual, solo que el directorio del proyecto es /ligaClient

	
	
