const menuButton = document.getElementById('menu')

const startShiftItem = document.getElementById('shift-begin')
const startRestItem = document.getElementById('rest-begin')
const endRestItem = document.getElementById('rest-end')
const endShiftItem = document.getElementById('shift-end')

const details = {
    startShift: new Date(Number(getCookie('sessionStarted'))),
}
fillSessionDetails(details)

function fillSessionDetails(userDetails) {
    const startShift = userDetails.startShift

    const startRest = new Date(startShift);
    startRest.setHours(startRest.getHours() + 2)

    const endRest = new Date(startShift);
    endRest.setHours(endRest.getHours() + 3)

    const endShift = new Date(startShift);
    endShift.setHours(endShift.getHours() + 5)

    startShiftItem.innerHTML = new Date(startShift).toString()
    startRestItem.innerHTML = startRest.toString()
    endRestItem.innerHTML = endRest.toString()
    endShiftItem.innerHTML = endShift.toString()
}

function getCookie(cname) {
    let name = cname + "=";
    let ca = document.cookie.split(';');
    for(let i = 0; i < ca.length; i++) {
      let c = ca[i];
      while (c.charAt(0) == ' ') {
        c = c.substring(1);
      }
      if (c.indexOf(name) == 0) {
        return c.substring(name.length, c.length);
      }
    }
    return "";
  }


