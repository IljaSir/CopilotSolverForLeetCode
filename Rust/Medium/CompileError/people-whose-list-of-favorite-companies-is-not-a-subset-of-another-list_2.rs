impl Solution {
    pub fn people_indexes(favorite_companies: Vec<Vec<String>>) -> Vec<i32> {
        
        let mut res = Vec::new();
        let mut favorite_companies: Vec<Vec<&str>> = favorite_companies.into_iter().map(|x| x.iter().map(|y| y.as_str()).collect()).collect();
        favorite_companies.sort_by(|a, b| a.len().cmp(&b.len()));
        for (i, c) in favorite_companies.iter().enumerate() {
            let mut is_subset = false;
            for j in (i + 1)..favorite_companies.len() {
                if c.iter().all(|x| favorite_companies[j].contains(x)) {
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