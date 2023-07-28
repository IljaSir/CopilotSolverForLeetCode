impl Solution {
    pub fn people_indexes(favorite_companies: Vec<Vec<String>>) -> Vec<i32> {
        
        let mut res = vec![];
        for i in 0..favorite_companies.len() {
            let mut is_subset = false;
            for j in 0..favorite_companies.len() {
                if i != j && favorite_companies[i].iter().all(|x| favorite_companies[j].contains(x)) {
                    is_subset = true;
                    break;
                }
            }
            if !is_subset {
                res.push(i as i32);
            }
        }
        res
    }
}