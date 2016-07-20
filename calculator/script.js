function switchType() {

  standard = document.getElementById('standard');
  scientific = document.getElementById('scientific');


  if (standard.style.display == 'block') {
    standard.style.display = 'none';
    scientific.style.display = 'block';
  } else {
    standard.style.display = 'block';
    scientific.style.display = 'none';
  }

}

function sqr() {

  var number = document.getElementById('Input').value;
  document.getElementById('Input').value = (number * number);
}

function sqrt() {

  var number = document.getElementById('Input').value;
  document.getElementById('Input').value = Math.sqrt(number);

}

function cub() {
  var number = document.getElementById('Input').value;
  document.getElementById('Input').value = (number * number * number);
}

function clear() {
  document.getElementById('Input').value = document.getElementById('Input').value.substring(0, document.getElementById('Input').value.length - 1);


}

function allClear() {
  document.getElementById('Input').value = " ";

}