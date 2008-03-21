/*
 * Copyright 2004-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.webflow.engine.model;

import org.springframework.webflow.engine.model.EndStateModel;

import junit.framework.TestCase;

/**
 * Unit tests for {@link EndStateModel}.
 */
public class EndStateModelTests extends TestCase {

	public void testMerge() {
		EndStateModel child = new EndStateModel("child");
		EndStateModel parent = new EndStateModel("parent");
		child.merge(parent);
		assertEquals("child", child.getId());
	}

	public void testMergeNullParent() {
		EndStateModel child = new EndStateModel("child");
		EndStateModel parent = null;
		child.merge(parent);
		assertEquals("child", child.getId());
	}

	public void testMergeOverrideMatch() {
		EndStateModel child = new EndStateModel("child");
		EndStateModel parent = new EndStateModel("child");
		parent.setCommit("true");
		child.merge(parent);
		assertEquals("true", child.getCommit());
	}

	public void testMergeOverrideMatchFailed() {
		EndStateModel child = new EndStateModel("child");
		EndStateModel parent = new EndStateModel("parent");
		parent.setCommit("true");
		child.merge(parent);
		assertEquals(null, child.getCommit());
	}

}