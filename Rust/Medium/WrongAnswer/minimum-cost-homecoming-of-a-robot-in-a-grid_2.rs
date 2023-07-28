impl Solution {
    pub fn min_cost(start_pos: Vec<i32>, home_pos: Vec<i32>, row_costs: Vec<i32>, col_costs: Vec<i32>) -> i32 {
        
        let mut row_costs = row_costs.clone();
        let mut col_costs = col_costs.clone();
        row_costs.sort();
        col_costs.sort();
        let mut ans = 0;
        let mut x = start_pos[0] as usize;
        let mut y = start_pos[1] as usize;
        let mut x_end = home_pos[0] as usize;
        let mut y_end = home_pos[1] as usize;
        while x != x_end || y != y_end {
            if x != x_end && y != y_end {
                if row_costs[x] < col_costs[y] {
                    ans += row_costs[x];
                    if x > x_end {
                        x -= 1;
                    } else {
                        x += 1;
                    }
                } else {
                    ans += col_costs[y];
                    if y > y_end {
                        y -= 1;
                    } else {
                        y += 1;
                    }
                }
            } else if x != x_end {
                ans += row_costs[x];
                if x > x_end {
                    x -= 1;
                } else {
                    x += 1;
                }
            } else {
                ans += col_costs[y];
                if y > y_end {
                    y -= 1;
                } else {
                    y += 1;
                }
            }
        }
        ans
    }
}