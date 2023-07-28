impl Solution {
    pub fn is_self_crossing(distance: Vec<i32>) -> bool {
        
        let mut distance = distance;
        let mut i = 0;
        while i + 3 < distance.len() {
            if distance[i] >= distance[i + 2] && distance[i + 1] <= distance[i + 3] {
                return true;
            }
            i += 1;
        }
        i = 0;
        while i + 2 < distance.len() {
            if distance[i] >= distance[i + 2] && distance[i + 1] == distance[i + 3] {
                return true;
            }
            i += 1;
        }
        i = 0;
        while i + 1 < distance.len() {
            if distance[i] == distance[i + 2] && distance[i + 1] <= distance[i + 3] {
                return true;
            }
            i += 1;
        }
        false
    }
}