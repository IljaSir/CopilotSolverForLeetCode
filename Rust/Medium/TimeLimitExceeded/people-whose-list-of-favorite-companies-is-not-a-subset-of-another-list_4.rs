impl Solution {
    pub fn people_indexes(favorite_companies: Vec<Vec<String>>) -> Vec<i32> {
        
        let mut ret: Vec<i32> = Vec::new();
        let mut len = favorite_companies.len();
        let mut i = 0;
        while i < len {
            let mut j = 0;
            while j < len {
                if i != j && favorite_companies[i].iter().all(|x| favorite_companies[j].contains(x)) {
                    break;
                }
                j += 1;
            }
            if j == len {
                ret.push(i as i32);
            }
            i += 1;
        }
        ret
    }
}