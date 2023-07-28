impl Solution {
    pub fn min_cost_connect_points(points: Vec<Vec<i32>>) -> i32 {
        
        let mut res = 0;
        let mut visited = vec![false; points.len()];
        let mut heap = BinaryHeap::new();
        heap.push(Reverse((0, 0)));
        while let Some(Reverse((cost, i))) = heap.pop() {
            if visited[i] {
                continue;
            }
            visited[i] = true;
            res += cost;
            for j in 0..points.len() {
                if !visited[j] {
                    let cost = (points[i][0] - points[j][0]).abs() + (points[i][1] - points[j][1]).abs();
                    heap.push(Reverse((cost, j)));
                }
            }
        }
        res
    }
}