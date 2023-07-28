impl Solution {
    pub fn minimum_time(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut queue = std::collections::VecDeque::new();
        let mut visited = std::collections::HashSet::new();
        let mut ans = 0;
        queue.push_back((0,0));
        while !queue.is_empty() {
            let mut next = std::collections::VecDeque::new();
            while !queue.is_empty() {
                let (x, y) = queue.pop_front().unwrap();
                if x == grid.len() - 1 && y == grid[0].len() - 1 {
                    return ans;
                }
                if visited.contains(&(x,y)) {
                    continue;
                }
                visited.insert((x,y));
                if x > 0 && ans >= grid[x-1][y] {
                    next.push_back((x-1,y));
                }
                if x < grid.len() - 1 && ans >= grid[x+1][y] {
                    next.push_back((x+1,y));
                }
                if y > 0 && ans >= grid[x][y-1] {
                    next.push_back((x,y-1));
                }
                if y < grid[0].len() - 1 && ans >= grid[x][y+1] {
                    next.push_back((x,y+1));
                }
            }
            queue = next;
            ans += 1;
        }
        return -1;
    }
}