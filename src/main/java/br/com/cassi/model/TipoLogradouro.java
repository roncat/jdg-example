package br.com.cassi.model;

import de.cronn.reflection.util.PropertyUtils;
import de.cronn.reflection.util.TypedPropertyGetter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "TBCDS048_TIPO_LGRDO", schema = "cds")
public class TipoLogradouro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TIPO_LGRDO")
    @SequenceGenerator(allocationSize = 1, name = "SQ_TIPO_LGRDO")
    @Column(name = "ID_TIPO_LGRDO")
    public Long id;

    @Column(name = "DS_TIPO_LGRDO", length = 100, nullable = false)
    public String descricao;

    @Column(name = "DT_OPRCO_INCLO", nullable = false)
    private Date dataOperacaoInclusao;

    @Column(name = "DT_OPRCO_ALTRO", nullable = false)
    private Date dataOperacaoAlteracao;

    @Column(name = "NR_CPF_OPRDR", length = 11, nullable = false)
    private String cpfOperador;

    @Column(name = "DT_OPRCO_EXCLO", nullable = true)
    private Date dataOperacaoExclusao;

    public TipoLogradouro() {
    }

    public TipoLogradouro(Long id, String descricao, Date dataOperacaoInclusao, Date dataOperacaoAlteracao,
            String cpfOperador, Date dataOperacaoExclusao) {
        this.id = id;
        this.descricao = descricao;
        this.dataOperacaoInclusao = dataOperacaoInclusao;
        this.dataOperacaoAlteracao = dataOperacaoAlteracao;
        this.cpfOperador = cpfOperador;
        this.dataOperacaoExclusao = dataOperacaoExclusao;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataOperacaoInclusao() {
        return this.dataOperacaoInclusao;
    }

    public void setDataOperacaoInclusao(Date dataOperacaoInclusao) {
        this.dataOperacaoInclusao = dataOperacaoInclusao;
    }

    public Date getDataOperacaoAlteracao() {
        return this.dataOperacaoAlteracao;
    }

    public void setDataOperacaoAlteracao(Date dataOperacaoAlteracao) {
        this.dataOperacaoAlteracao = dataOperacaoAlteracao;
    }

    public String getCpfOperador() {
        return this.cpfOperador;
    }

    public void setCpfOperador(String cpfOperador) {
        this.cpfOperador = cpfOperador;
    }

    public Date getDataOperacaoExclusao() {
        return this.dataOperacaoExclusao;
    }

    public void setDataOperacaoExclusao(Date dataOperacaoExclusao) {
        this.dataOperacaoExclusao = dataOperacaoExclusao;
    }

    public TipoLogradouro id(Long id) {
        this.id = id;
        return this;
    }

    public TipoLogradouro descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public TipoLogradouro dataOperacaoInclusao(Date dataOperacaoInclusao) {
        this.dataOperacaoInclusao = dataOperacaoInclusao;
        return this;
    }

    public TipoLogradouro dataOperacaoAlteracao(Date dataOperacaoAlteracao) {
        this.dataOperacaoAlteracao = dataOperacaoAlteracao;
        return this;
    }

    public TipoLogradouro cpfOperador(String cpfOperador) {
        this.cpfOperador = cpfOperador;
        return this;
    }

    public TipoLogradouro dataOperacaoExclusao(Date dataOperacaoExclusao) {
        this.dataOperacaoExclusao = dataOperacaoExclusao;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TipoLogradouro)) {
            return false;
        }
        TipoLogradouro tipoLogradouro = (TipoLogradouro) o;
        return Objects.equals(id, tipoLogradouro.id) && Objects.equals(descricao, tipoLogradouro.descricao)
                && Objects.equals(dataOperacaoInclusao, tipoLogradouro.dataOperacaoInclusao)
                && Objects.equals(dataOperacaoAlteracao, tipoLogradouro.dataOperacaoAlteracao)
                && Objects.equals(cpfOperador, tipoLogradouro.cpfOperador)
                && Objects.equals(dataOperacaoExclusao, tipoLogradouro.dataOperacaoExclusao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, dataOperacaoInclusao, dataOperacaoAlteracao, cpfOperador,
                dataOperacaoExclusao);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", descricao='" + getDescricao() + "'" + ", dataOperacaoInclusao='"
                + getDataOperacaoInclusao() + "'" + ", dataOperacaoAlteracao='" + getDataOperacaoAlteracao() + "'"
                + ", cpfOperador='" + getCpfOperador() + "'" + ", dataOperacaoExclusao='" + getDataOperacaoExclusao()
                + "'" + "}";
    }

    // Utility method to retrieve entity property names (using java reflection)
    // https://github.com/cronn-de/reflection-util

    @Transient
    public static String getJPAColumnName(TypedPropertyGetter<TipoLogradouro, ?> typedProperty) {
        return PropertyUtils.getPropertyName(TipoLogradouro.class, typedProperty);
    }

}
