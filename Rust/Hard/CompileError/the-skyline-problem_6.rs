impl Solution {
    pub fn get_skyline(buildings: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut res = vec![];
        let mut hq = std::collections::BinaryHeap::new();
        let mut i = 0;
        let mut n = buildings.len();
        while i < n || !hq.is_empty() {
            let x = if hq.is_empty() { buildings[i][0] } else { hq.peek().unwrap().1 };
            if i == n || x < buildings[i][0] {
                while !hq.is_empty() && hq.peek().unwrap().1 <= x {
                    hq.pop();
                }
            } else {
                x = buildings[i][0];
                while i < n && buildings[i][0] == x {
                    hq.push((buildings[i][2], buildings[i][1]));
                    i += 1;
                }
            }
            let h = if hq.is_empty() { 0 } else { hq.peek().unwrap().0 };
            if res.is_empty() || res.last().unwrap()[1] != h {
                res.push(vec![x, h]);
            }
        }
        res
    }
}