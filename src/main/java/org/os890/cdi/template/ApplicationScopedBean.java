/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.os890.cdi.template;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * Application-scoped CDI bean that delegates to {@link StatelessEJB}.
 */
@ApplicationScoped
public class ApplicationScopedBean
{
    @EJB //or @Inject
    private StatelessEJB statelessEJB;

    /**
     * Returns the value provided by the injected {@link StatelessEJB}.
     *
     * @return the service value
     */
    public int getValue()
    {
        return statelessEJB.getValue();
    }
}
