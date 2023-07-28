impl Solution {
    pub fn maximum_invitations(favorite: Vec<i32>) -> i32 {
        
        let mut visited = vec![false; favorite.len()];
        let mut result = 0;
        for i in 0..favorite.len() {
            if visited[i] {
                continue;
            }
            let mut cur = i as i32;
            let mut count = 0;
            while !visited[cur as usize] {
                visited[cur as usize] = true;
                cur = favorite[cur as usize];
                count += 1;
            }
            result += count;
        }
        result
    }
}