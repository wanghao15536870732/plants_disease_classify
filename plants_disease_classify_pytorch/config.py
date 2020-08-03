class DefaultConfigs(object):
    # 1.string parameters
    train_data = "./data/train/"
    test_data = "./data/test/"
    test_one_data = "./data/onetest/"
    val_data = "no"
    model_name = "resnet50"
    weights = "./checkpoints/"
    best_models = weights + "best_model/"
    submit = "./submit/"
    logs = "./logs/"
    gpus = "0,1,2,3"

    # 2.numeric parameters
    epochs = 40
    batch_size = 3
    img_height = 325
    img_weight = 325
    num_classes = 59
    seed = 888
    lr = 1e-4
    lr_decay = 1e-4
    weight_decay = 1e-4

    # 3.label parameters
    LABEL_NAMES = ["苹果健康", "苹果黑星病一般", "苹果黑星病严重", "苹果灰斑病", "苹果雪松锈病一般",
                   "苹果雪松锈病严重", "樱桃健康", "樱桃白粉病一般", "樱桃白粉病严重", "玉米健康",
                   "玉米灰斑病一般", "玉米灰斑病严重", "玉米锈病一般", "玉米锈病严重", "玉米叶斑病一般",
                   "玉米叶斑病严重", "玉米花叶病毒病", "葡萄健康", "葡萄黑腐病一般", "葡萄黑腐病严重",
                   "葡萄轮斑病一般", "葡萄轮斑病严重", "葡萄褐斑病一般", "葡萄褐斑病严重", "柑桔健康",
                   "柑桔黄龙病一般", "柑桔黄龙病严重", "桃健康", "桃疮痂病一般", "桃疮痂病严重",
                   "辣椒健康", "辣椒疮痂病一般", "辣椒疮痂病严重", "马铃薯健康", "马铃薯早疫病一般",
                   "马铃薯早疫病严重", "马铃薯晚疫病一般", "马铃薯晚疫病严重", "草莓健康", "草莓叶枯病一般",
                   "草莓叶枯病严重", "番茄健康", "番茄白粉病一般", "番茄白粉病严重", "番茄疮痂病一般",
                   "番茄疮痂病严重", "番茄早疫病一般", "番茄早疫病严重", "番茄晚疫病菌一般", "番茄晚疫病菌严重",
                   "番茄叶霉病一般", "番茄叶霉病严重", "番茄斑点病一般", "番茄斑点病严重", "番茄斑枯病一般",
                   "番茄斑枯病严重", "番茄红蜘蛛损伤一般", "番茄红蜘蛛损伤严重", "番茄黄化曲叶病毒病一般", "番茄黄化曲叶病毒病严重",
                   "番茄花叶病毒病"]


config = DefaultConfigs()
