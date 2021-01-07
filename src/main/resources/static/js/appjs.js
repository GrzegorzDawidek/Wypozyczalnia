 function startValidation(firstFieldSelector, secondFieldSelector) {
               const getDateParts = (dateString) => {
                    let h = dateString.split(':')[0];
                    let m = dateString.split(':')[1];

                    return {h: parseInt(h), m: parseInt(m)}
               }

               const setMin = (firstField, secondField) => {

                    const firstFieldValue = getDateParts(firstField.target.value);
                    if (secondField.value === '' || secondField.value === null || secondField.value === undefined) {
                        let h = firstFieldValue.h+1;
                        secondField.value = `${h.toString().padStart(2, '0')}:${firstFieldValue.m.toString().padStart(2, '0')}`;
                    }


                    const secondFieldValue = getDateParts(secondField.value);

                    if (secondFieldValue.h < firstFieldValue.h || secondFieldValue.h === firstFieldValue.h || secondFieldValue.h === firstFieldValue.h+1) {
                         let h = firstFieldValue.h+1;
                         secondField.value = `${h.toString().padStart(2, '0')}:${firstFieldValue.m.toString().padStart(2, '0')}`;
                    }

               }

               const setMax = (secondField, firstField) => {
               const secondFieldValue = getDateParts(secondField.target.value);
                    if (firstField.value === '' || firstField.value === null || firstField.value === undefined) {
                           let h = secondFieldValue.h-1;
                           firstField.value = `${h.toString().padStart(2, '0')}:${secondFieldValue.m.toString().padStart(2, '0')}`;
                    }


                    const firstFieldValue = getDateParts(firstField.value);

                    if (secondFieldValue.h < firstFieldValue.h   || firstFieldValue.h === secondFieldValue.h ||  firstFieldValue.h === secondFieldValue.h-1 ) {
                             let h = secondFieldValue.h-1;
                             firstField.value = `${h.toString().padStart(2, '0')}:${secondFieldValue.m.toString().padStart(2, '0')}`;
                    }
               }

               const firstField = document.querySelector(firstFieldSelector)
               const secondField = document.querySelector(secondFieldSelector)


               firstField.addEventListener('change', (event) => {
                    setMin(event, secondField)
               })
               secondField.addEventListener('change', (event) => {
                    setMax(event, firstField)
               })
          }


window.addEventListener("load", function() {
  const timefields = Array.from(document.querySelectorAll('[id^="start-"]')).forEach(el=>{
  startValidation(`#${el.id}`,`#${el.id.replace("start","end")}`)
  })

});
