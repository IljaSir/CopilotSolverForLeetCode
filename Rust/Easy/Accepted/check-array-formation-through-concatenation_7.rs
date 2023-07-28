impl Solution {
    pub fn can_form_array(arr: Vec<i32>, pieces: Vec<Vec<i32>>) -> bool {
        
        let mut d = std::collections::HashMap::new();
        for p in pieces {
            d.insert(p[0], p);
        }
        let mut i = 0;
        while i < arr.len() {
            if let Some(p) = d.get(&arr[i]) {
                for j in 0..p.len() {
                    if arr[i + j] != p[j] {
                        return false;
                    }
                }
                i += p.len();
            } else {
                return false;
            }
        }
        true
    }
}