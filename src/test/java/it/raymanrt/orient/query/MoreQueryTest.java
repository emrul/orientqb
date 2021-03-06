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

import org.junit.Test;

import static it.raymanrt.orient.query.Parameter.PARAMETER;
import static it.raymanrt.orient.query.Parameter.parameter;
import static it.raymanrt.orient.query.Projection.projection;
import static it.raymanrt.orient.query.ProjectionFunction.out;
import static org.junit.Assert.assertEquals;

public class MoreQueryTest {

	@Test
	public void complexWhereQueryTest() {
		Query q = new Query()
			.where(projection("a").eq(true))
			.where(Clause.or(
					projection("b").eq(true),
					projection("c").eq(true)
			))
		;
		assertEquals("SELECT FROM V WHERE a = true AND (b = true OR c = true)", q.toString());
	}

	@Test
	public void notVeryComplexWhereQueryTest() {
		Query q = new Query()
				.where(Clause.or(
						projection("b").eq(true),
						projection("c").eq(true)
				))
				;
		assertEquals("SELECT FROM V WHERE b = true OR c = true", q.toString());
	}

	@Test
	public void parameterAsProjectionTest() {
		Query q = new Query()
				.where(PARAMETER.eq(5));
		assertEquals("SELECT FROM V WHERE ? = 5", q.toString());
	}

	@Test
	public void namedParameterAsProjectionTest() {
		Query q = new Query()
				.where(out("label").contains(parameter("par")));
		assertEquals("SELECT FROM V WHERE out('label') CONTAINS :par", q.toString());
	}
}