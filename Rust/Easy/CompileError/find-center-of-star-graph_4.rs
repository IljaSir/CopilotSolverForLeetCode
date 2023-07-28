impl Solution {
    pub fn find_center(edges: Vec<Vec<i32>>) -> i32 {
        
        let mut freq = vec![0; 100001];
        for edge in edges {
            freq[edge[0] as usize] += 1;
            freq[edge[1] as usize] += 1;
        }
        for i in 1..freq.len() {
            if freq[i] == edges.len() {
                return i as i32;
            }
        }
        0
    }
}