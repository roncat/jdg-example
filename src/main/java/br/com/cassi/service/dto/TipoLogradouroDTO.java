package br.com.cassi.service.dto;

import java.util.Date;
import java.util.Objects;

public class TipoLogradouroDTO {
    private Long id;
    private String descricao;
    private Date dataOperacaoInclusao;
    private Date dataOperacaoAlteracao;
    private String cpfOperador;
    private Date dataOperacaoExclusao;

    public TipoLogradouroDTO() {
    }

    public TipoLogradouroDTO(Long id, String descricao, Date dataOperacaoInclusao, Date dataOperacaoAlteracao,
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

    public TipoLogradouroDTO id(Long id) {
        this.id = id;
        return this;
    }

    public TipoLogradouroDTO descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public TipoLogradouroDTO dataOperacaoInclusao(Date dataOperacaoInclusao) {
        this.dataOperacaoInclusao = dataOperacaoInclusao;
        return this;
    }

    public TipoLogradouroDTO dataOperacaoAlteracao(Date dataOperacaoAlteracao) {
        this.dataOperacaoAlteracao = dataOperacaoAlteracao;
        return this;
    }

    public TipoLogradouroDTO cpfOperador(String cpfOperador) {
        this.cpfOperador = cpfOperador;
        return this;
    }

    public TipoLogradouroDTO dataOperacaoExclusao(Date dataOperacaoExclusao) {
        this.dataOperacaoExclusao = dataOperacaoExclusao;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TipoLogradouroDTO)) {
            return false;
        }
        TipoLogradouroDTO tipoLogradouroDTO = (TipoLogradouroDTO) o;
        return Objects.equals(id, tipoLogradouroDTO.id) && Objects.equals(descricao, tipoLogradouroDTO.descricao)
                && Objects.equals(dataOperacaoInclusao, tipoLogradouroDTO.dataOperacaoInclusao)
                && Objects.equals(dataOperacaoAlteracao, tipoLogradouroDTO.dataOperacaoAlteracao)
                && Objects.equals(cpfOperador, tipoLogradouroDTO.cpfOperador)
                && Objects.equals(dataOperacaoExclusao, tipoLogradouroDTO.dataOperacaoExclusao);
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

}