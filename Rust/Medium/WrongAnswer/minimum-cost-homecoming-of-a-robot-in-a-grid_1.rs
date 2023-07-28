impl Solution {
    pub fn min_cost(start_pos: Vec<i32>, home_pos: Vec<i32>, row_costs: Vec<i32>, col_costs: Vec<i32>) -> i32 {
        
        let mut row_costs = row_costs;
        let mut col_costs = col_costs;
        row_costs.sort_unstable();
        col_costs.sort_unstable();
        let mut ans = 0;
        let (mut x, mut y) = (start_pos[0], start_pos[1]);
        while x != home_pos[0] {
            let (nx, ny) = (x + (home_pos[0] - x).signum(), y);
            let cost = row_costs[nx as usize];
            ans += cost;
            x = nx;
            y = ny;
        }
        while y != home_pos[1] {
            let (nx, ny) = (x, y + (home_pos[1] - y).signum());
            let cost = col_costs[ny as usize];
            ans += cost;
            x = nx;
            y = ny;
        }
        ans
    }
}