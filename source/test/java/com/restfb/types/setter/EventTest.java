/*
 * Copyright (c) 2010-2014 Norbert Bartels
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.restfb.types.setter;

import com.restfb.types.Event;
import com.restfb.types.api.SetterGetterTestBase;
import org.junit.Test;

public class EventTest extends SetterGetterTestBase {
    
    @Test
    public void test() {
	Event obj = new Event();
	addIgnoredField("rawStartTime");
	addIgnoredField("rawEndTime");
	addIgnoredField("rawUpdatedTime");
	testInstance(obj);
    }
    
    @Test
    public void testOwner() {
	Event.Owner obj = new Event.Owner();
	addIgnoredField("rawIssuedAt");
	testInstance(obj);
    }
    
    @Test
    public void testCategory() {
	Event.Category obj = new Event.Category();
	addIgnoredField("rawIssuedAt");
	testInstance(obj);
    }
}
