/*
 * Copyright 2015 Riccardo Tasso
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package it.raymanrt.orient.query;

import it.raymanrt.orient.query.clause.AtomicClause;
import it.raymanrt.orient.query.clause.CompositeClause;
import it.raymanrt.orient.query.clause.CustomFormatClause;
import it.raymanrt.orient.util.Joiner;

import static it.raymanrt.orient.query.Operator.NOT;

public class Clause {

    public static final Clause clause(String field, Operator operator, Object value) {
        return new AtomicClause(field, operator, value);
    }

    public static final Clause clause(Projection projection, Operator operator, Object value) {
        return new AtomicClause(projection, operator, value);
    }

    public static final Clause and(Clause ... clauses) {
        return new CompositeClause(Joiner.andJoiner, clauses);
    }

    public static final Clause not(Clause clause) {
        return new CustomFormatClause(NOT, clause);
    }

    public static final Clause or(Clause ... clauses) {
        return new CompositeClause(Joiner.orJoiner, clauses);
    }
}