impl Solution {
    pub fn remove_subfolders(folder: Vec<String>) -> Vec<String> {
        
        let mut folder: Vec<Vec<&str>> = folder.iter().map(|x| x.split('/').collect()).collect();
        folder.sort_by(|a, b| a.len().cmp(&b.len()));
        let mut res = vec![];
        let mut set = std::collections::HashSet::new();
        for f in folder {
            let mut path = String::new();
            let mut flag = true;
            for i in 1..f.len() {
                path.push('/');
                path.push_str(f[i]);
                if set.contains(&path) {
                    flag = false;
                    break;
                }
            }
            if flag {
                res.push(f.join("/"));
            }
            set.insert(f.join("/"));
        }
        res
    }
}