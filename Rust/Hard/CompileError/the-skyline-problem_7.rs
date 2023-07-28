impl Solution {
    pub fn get_skyline(buildings: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut res = Vec::new();
        let mut heap = std::collections::BinaryHeap::new();
        let mut i = 0;
        let mut n = buildings.len();
        let mut cur = 0;
        let mut x = 0;
        let mut y = 0;
        let mut live = Vec::new();
        while i < n || !heap.is_empty() {
            if heap.is_empty() {
                x = buildings[i][0];
            } else {
                x = heap.peek().unwrap().1;
                while i < n && buildings[i][0] <= x {
                    heap.push((-buildings[i][2], buildings[i][1]));
                    i += 1;
                }
                while !heap.is_empty() && heap.peek().unwrap().1 <= x {
                    heap.pop();
                }
            }
            y = if heap.is_empty() { 0 } else { -heap.peek().unwrap().0 };
            if res.is_empty() || res.last().unwrap()[1] != y {
                res.push(vec![x, y]);
            }
        }
        res
    }
}