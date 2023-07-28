impl Solution {
    pub fn longest_cycle(edges: Vec<i32>) -> i32 {
        
        let n = edges.len();
        let mut res = 0;
        let mut visited = vec![false; n];
        for i in 0..n {
            if visited[i] {
                continue;
            }
            let mut start = i;
            let mut end = i;
            let mut length = 0;
            while edges[end] != -1 {
                start = end;
                end = edges[end] as usize;
                length += 1;
                if visited[start] {
                    break;
                }
                visited[start] = true;
            }
            if start == end {
                res = res.max(length);
            }
        }
        if res == 0 {
            -1
        } else {
            res as i32
        }
    }
}