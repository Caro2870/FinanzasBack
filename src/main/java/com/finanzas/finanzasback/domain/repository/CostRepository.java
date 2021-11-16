package com.finanzas.finanzasback.domain.repository;

import com.finanzas.finanzasback.domain.model.Cost;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

import javax.persistence.NamedNativeQuery;
import java.util.List;

@Repository
public interface CostRepository extends JpaRepository<Cost, Long> {

    public Page<Cost> findById(Long Id, Pageable page);

    @Query(nativeQuery = true, value = "select value from costs where fee_receipt_id = :fee_receipt_id AND cost_type = true  AND value_type = true")
    List<Number> valorInicial_valor(@Param("fee_receipt_id")Integer fee_receipt_id);

    @Query(nativeQuery = true, value = "select value from costs where fee_receipt_id = :fee_receipt_id AND cost_type = true  AND value_type = false")
    List<Number> valorInicial_porcentaje(@Param("fee_receipt_id")Integer fee_receipt_id);

    @Query(nativeQuery = true, value = "select value from costs where fee_receipt_id = :fee_receipt_id AND cost_type = false  AND value_type = true")
    List<Number> valorFinal_valor(@Param("fee_receipt_id")Integer fee_receipt_id);

    @Query(nativeQuery = true, value = "select value from costs where fee_receipt_id = :fee_receipt_id AND cost_type = false  AND value_type = false ")
    List<Number> valorFinal_porcentaje(@Param("fee_receipt_id")Integer fee_receipt_id);

}
