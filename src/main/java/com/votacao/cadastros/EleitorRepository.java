package com.votacao.cadastros;

import org.springframework.data.repository.CrudRepository;

public interface EleitorRepository extends CrudRepository<Eleitor, String> {
}
