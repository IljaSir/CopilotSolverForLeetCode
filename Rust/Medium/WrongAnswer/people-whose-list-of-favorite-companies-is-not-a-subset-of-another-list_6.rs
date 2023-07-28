impl Solution {
    pub fn people_indexes(favorite_companies: Vec<Vec<String>>) -> Vec<i32> {
        
        let mut res = vec![];
        let mut fcs = favorite_companies.iter().map(|fc| {
            let mut set = std::collections::HashSet::new();
            for s in fc {
                set.insert(s.as_str());
            }
            set
        }).collect::<Vec<_>>();
        fcs.sort_by_key(|fc| fc.len());
        for i in 0..fcs.len() {
            let mut flag = true;
            for j in 0..fcs.len() {
                if i == j {
                    continue;
                }
                if fcs[i].is_subset(&fcs[j]) {
                    flag = false;
                    break;
                }
            }
            if flag {
                res.push(i as i32);
            }
        }
        res
    }
}