package br.com.framework.interfac.crud;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public interface InterfaceCrud<T> extends Serializable{
	
	//Salva os dados
	void save(T obj) throws Exception;
	
	void persist(T obj) throws Exception;
	
	//Salva ou Atualiza os dados
	void saveOrUpdate(T obj) throws Exception;
	
	//Realiza o update(Atualição) de dados
	void update(T obj) throws Exception;
	
	//Realiza o delete(deleta) nos dados
	void delete(T obj) throws Exception;
	
	//Salva ou atualiza e retorna o objeto em estado persistente
	T merge (T obj) throws Exception;
	
	//Carrega a lista de dados de determinada classe
	List<T> findList(Class<T> obj) throws Exception;
	
	T findById(Class<T> entidade, Long id) throws Exception;
	
	List<T> findListByQueryDynamic(String s) throws Exception;
	
	//Executar update com HQL
	void executeUpdateQueryDynamic(String s) throws Exception;
	
	//Executar update com SQL
	void executeUpdateSQLDynamic(String s) throws Exception;
	
	//Limpar a sessao do Hibernate
	void clearSession() throws Exception;
	
	//Retira Objeto da sessão do Hibrnate
	void evict(T obj) throws Exception;
	
	Session getSession() throws Exception;
	
	List<?> getListSQLDynamic(String sql) throws Exception;
	
	//JDBC do Spring
	JdbcTemplate getJdbcTemplate();
	
	SimpleJdbcTemplate getSimpleJdbcTemplate();
	
	SimpleJdbcInsert getSimpleJdbcInsert();
	
	//CArrega numero total de registros
	Long totalRegistro(String table) throws Exception;
	
	Query obterQuery(String query) throws Exception;
	
	List<Object[]> getListSQLDynamicArray(String sql) throws Exception;
	
	//Carregamento dinamico com JSF e PrimeFaces
	List<T> findListByQueryDynamic(String query, int iniciaNoRegistro, int maximoResultado) throws Exception;
	
}
