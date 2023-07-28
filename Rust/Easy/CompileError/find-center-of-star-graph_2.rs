impl Solution {
    pub fn find_center(edges: Vec<Vec<i32>>) -> i32 {
        
        let mut count = vec![0; edges.len()+2];
        for edge in edges {
            count[edge[0] as usize] += 1;
            count[edge[1] as usize] += 1;
        }
        for i in 1..count.len() {
            if count[i] == edges.len() {
                return i as i32;
            }
        }
        return 0;
    }
}