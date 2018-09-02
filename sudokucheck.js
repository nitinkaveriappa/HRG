var sudoku_data = [
  [5,3,4,6,7,8,9,1,2],
  [6,7,2,1,9,5,3,4,8],
  [1,9,8,3,4,2,5,6,7],
  [8,5,9,7,6,1,4,2,3],
  [4,2,6,8,5,3,7,9,1],
  [7,1,3,9,2,4,8,5,6],
  [9,6,1,5,3,7,2,8,4],
  [2,8,7,4,1,9,6,3,5],
  [3,4,5,2,8,6,1,7,9]
];

var bad_data = [
  [1,1,1,1,1,1,1,1,1],
  [6,7,2,1,9,5,3,4,8],
  [1,9,8,3,4,2,5,6,7],
  [8,5,9,7,6,1,4,2,3],
  [4,2,6,8,5,3,7,9,1],
  [7,1,3,9,2,4,8,5,6],
  [9,6,1,5,3,7,2,8,4],
  [2,8,7,4,1,9,6,3,5],
  [3,4,5,2,8,6,1,7,9]
];

function check_rows(data) {
  var t2 = 0;
	for (var row = 0; row<9; row++) {
  	t2 = 0;
  	for (var col = 0; col<9; col++) {
    	t2 += data[row][col];
    }
    if(t2 != 45) {
    	return 0;
    }
	}
	return 1;
}

function check_columns(data) {
  var t2 = 0;
	for (var row = 0; row<9; row++) {
  	t2 = 0;
  	for (var col = 0; col<9; col++) {
    	t2 += data[col][row];
    }
    if(t2 != 45) {
    	return 0;
    }
	}
	return 1;
}

function check_grids(data) {
	var grid = [];
  var t2 = 0;
	for (var i = 0; i < 9; i++) {
    grid.push([]);
  }
	for (var row = 0; row<9; row++) {
  	for (var col = 0; col<9; col++) {
			 // Calculate grid identifiers
      gridrow = Math.floor( row / 3 );
      gridcol = Math.floor( col / 3 );
      index = gridrow * 3 + gridcol;

      // Save each grid in a new row
      grid[index].push(data[row][col]);
    }
	}
  for (var j = 0; i < 9; i++) {
  	t2 = 0;
  	for (var k = 0; j < 9; j++) {
    	t2 += grid[j][k];
    }
    if(t2 != 45) {
    	return 0;
    }
	}
	return 1;
}

function validate_sudoku(data) {
	if(check_rows(data) && check_columns(data) && check_grids(data)) {
  	return 1;
  }
  return 0;
}

console.info(validate_sudoku(sudoku_data));
console.info(validate_sudoku(bad_data));

/* console.info(check_rows(sudoku_data));
console.info(check_rows(bad_data));
console.info(check_columns(sudoku_data));
console.info(check_columns(bad_data));
console.info(check_grids(sudoku_data));
console.info(check_grids(bad_data)); */

/* console.info(sudoku_data[0][0]);
console.info(sudoku_data[0][1]);
console.info(sudoku_data[1][0]);

console.info(sudoku_data); */
