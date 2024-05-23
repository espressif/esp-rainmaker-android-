// Copyright 2024 Espressif Systems (Shanghai) PTE LTD
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.espressif.utils

import com.espressif.AppConstants
import com.espressif.ui.models.Param

class ParamUtils {

    companion object {

        fun filterActionParams(params: java.util.ArrayList<Param>): ArrayList<Param> {

            var actionParams = java.util.ArrayList<Param>()
            val iterator: Iterator<Param> = params.iterator()
            while (iterator.hasNext()) {
                val p = iterator.next()
                actionParams.add(Param(p))
            }

            val paramItr = actionParams.iterator()

            while (paramItr.hasNext()) {

                val p = paramItr.next() as Param

                if ((p.paramType != null && p.paramType == AppConstants.PARAM_TYPE_NAME)
                    || (!p.properties.contains(AppConstants.KEY_PROPERTY_WRITE)
                            || !p.isDynamicParam)
                ) {
                    paramItr.remove()
                }
            }
            return actionParams
        }
    }
}