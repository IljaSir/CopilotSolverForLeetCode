impl Solution {
    pub fn num_magic_squares_inside(grid: Vec<Vec<i32>>) -> i32 {
        
        if grid.len() < 3 || grid[0].len() < 3 {
            return 0;
        }
        let mut count = 0;
        for i in 0..grid.len() - 2 {
            for j in 0..grid[i].len() - 2 {
                let mut nums = [0; 16];
                let mut sum = 0;
                let mut k = 0;
                while k < 3 {
                    let mut row_sum = 0;
                    let mut col_sum = 0;
                    let mut l = 0;
                    while l < 3 {
                        let num = grid[i + k][j + l];
                        if num < 1 || num > 9 || nums[num as usize] > 0 {
                            break;
                        }
                        nums[num as usize] = 1;
                        row_sum += num;
                        col_sum += grid[i + l][j + k];
                        l += 1;
                    }
                    if l < 3 {
                        break;
                    }
                    if k == 0 {
                        sum = row_sum;
                    } else if sum != row_sum || sum != col_sum {
                        break;
                    }
                    k += 1;
                }
                if k == 3 && sum == grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2]
                    && sum == grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] {
                    count += 1;
                }
            }
        }
        count
    }
}