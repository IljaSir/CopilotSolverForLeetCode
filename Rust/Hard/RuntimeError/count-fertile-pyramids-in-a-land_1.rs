impl Solution {
    pub fn count_pyramids(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut result = 0;
        let height = grid.len();
        let width = grid[0].len();
        for i in 0..height {
            for j in 0..width {
                if grid[i][j] == 1 {
                    let mut h = 1;
                    while i + h < height && j - h >= 0 && j + h < width {
                        let mut valid = true;
                        for k in 0..h {
                            if grid[i + h][j - k] == 0 || grid[i + h][j + k] == 0 {
                                valid = false;
                                break;
                            }
                        }
                        if valid {
                            result += 1;
                        } else {
                            break;
                        }
                        h += 1;
                    }
                    let mut h = 1;
                    while i - h >= 0 && j - h >= 0 && j + h < width {
                        let mut valid = true;
                        for k in 0..h {
                            if grid[i - h][j - k] == 0 || grid[i - h][j + k] == 0 {
                                valid = false;
                                break;
                            }
                        }
                        if valid {
                            result += 1;
                        } else {
                            break;
                        }
                        h += 1;
                    }
                }
            }
        }
        result
    }
}