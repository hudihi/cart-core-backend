package org.example.ecommerce.common;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class HDNamingStrategy implements PhysicalNamingStrategy {
    @Override
    public Identifier toPhysicalCatalogName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
        return new Identifier("HD_" + logicalName.getText(), logicalName.isQuoted());
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
        return new Identifier("HD_" + logicalName.getText(), logicalName.isQuoted());
    }

    @Override
    public Identifier toPhysicalTableName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
        return new Identifier("HD_" + logicalName.getText(), logicalName.isQuoted());
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
        return new Identifier("HD_" + logicalName.getText(), logicalName.isQuoted());
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
        return new Identifier("HD_" + logicalName.getText(), logicalName.isQuoted());
    }
}
