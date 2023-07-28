impl Solution {
    pub fn get_skyline(buildings: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut res = vec![];
        let mut h = std::collections::BinaryHeap::new();
        let mut i = 0;
        let mut n = buildings.len();
        while i < n || !h.is_empty() {
            let mut x = if h.is_empty() { buildings[i][0] } else { h.peek().unwrap().1 };
            if i == n || buildings[i][0] > x {
                while !h.is_empty() && h.peek().unwrap().1 <= x {
                    h.pop();
                }
            } else {
                x = buildings[i][0];
                while i < n && buildings[i][0] == x {
                    h.push((buildings[i][2], buildings[i][1]));
                    i += 1;
                }
            }
            let mut y = if h.is_empty() { 0 } else { h.peek().unwrap().0 };
            if res.is_empty() || res.last().unwrap()[1] != y {
                res.push(vec![x, y]);
            }
        }
        res
    }
}