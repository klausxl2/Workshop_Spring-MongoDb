package com.lucas.workspace.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lucas.workspace.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

/*DEFINE A CLASSE COMO UM TRATADOR DE EXECEÇÕES DO CONTROLADOR, FAZ COM QUE 
 * TODA A EXCESSÃO QUE OCORRA DENTRO DOS CONTROLODORES SEJA TRATADA AQUI.
 * */
@ControllerAdvice
public class ResourceExceptionHandler {

	/*INDICA QUE SEMPRE QUE OCORRER UM EXCESÃO DO TIPO OBJECTNOTFOUND
	 * ESSE METÓDO SERÁ CHAMADO */
	@ExceptionHandler(ObjectNotFoundException.class)
	//HTTPSERVLET SERVE PARA ACESSAR INFORMAÇÕES DA REQUISIÇÃO HTTP ,COMO A URI SOLICITADA
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e , HttpServletRequest request){
		HttpStatus  status = HttpStatus.NOT_FOUND;//RETORNA O ERRO 404 NOT FOUND
		//OBJETO PERSONALIZADO QUE ARMAZENA DETALHES SOBRE O ERRO , COMO MOMENTO EXATO DO ERRO,VALUE,PATH
		StandardError err = new StandardError(System.currentTimeMillis(),status.value(),"Não encontrado",e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);//RETORNANDO A RESPOSTA PERSONALIZADA COMO O ERRO 404
	}
}
