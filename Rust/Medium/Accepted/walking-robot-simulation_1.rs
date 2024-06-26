impl Solution {
    pub fn robot_sim(commands: Vec<i32>, obstacles: Vec<Vec<i32>>) -> i32 {
        
        let mut x = 0;
        let mut y = 0;
        let mut d = 0;
        let mut max = 0;
        let mut ob = Vec::new();
        for o in obstacles {
            ob.push((o[0], o[1]));
        }
        let mut dir = vec![(0, 1), (1, 0), (0, -1), (-1, 0)];
        for c in commands {
            if c == -2 {
                d = (d + 3) % 4;
            } else if c == -1 {
                d = (d + 1) % 4;
            } else {
                for _ in 0..c {
                    x += dir[d].0;
                    y += dir[d].1;
                    if ob.contains(&(x, y)) {
                        x -= dir[d].0;
                        y -= dir[d].1;
                        break;
                    }
                }
                max = std::cmp::max(max, x * x + y * y);
            }
        }
        max
    }
}